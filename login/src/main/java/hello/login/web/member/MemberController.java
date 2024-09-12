package hello.login.web.member;


import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {

    private final MemberRepository memberRepository;

    // @ModelAttribute에 ("member")는 안넣어도 되지만, 타임리프에서 th:object 쓸 떄 못잡는 경우가 발생
    @GetMapping("add")
    public String addFOrm(@ModelAttribute("member") Member member) {
        return "members/addMemberForm";
    }

    @PostMapping("add")
    public String saver(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        memberRepository.save(member);
        return "redirect:/";
    }
}
