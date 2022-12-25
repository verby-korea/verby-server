package verby.apiserver.cover.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import verby.apiserver.config.security.SecurityUser;
import verby.apiserver.cover.command.application.CoverLikeService;

@RestController
@RequestMapping("/covers")
@RequiredArgsConstructor
public class CoverLikeController {

    private final CoverLikeService likeService;

    @PostMapping("/{coverId}/likes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void like(@AuthenticationPrincipal SecurityUser user, @PathVariable Long coverId) {
        likeService.like(user.getUserId(), coverId);
    }

    @DeleteMapping("/{coverId}/likes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unlike(@AuthenticationPrincipal SecurityUser user, @PathVariable Long coverId) {
        likeService.unlike(user.getUserId(), coverId);
    }

}
