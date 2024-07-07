package gift.controller;


import gift.dto.JwtResponse;
import gift.dto.MemberRequest;
import gift.service.MemberService;


import gift.dto.JwtDto;
import gift.dto.MemberDto;
import gift.service.MemberService;
import org.springframework.http.HttpHeaders;


@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody MemberRequest memberDto){
        String token = memberService.register(memberDto);

        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody MemberRequest memberDto){

        String token = memberService.login(memberDto.getEmail(), memberDto.getPassword());

        if (token != null) {
            return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

    }
}