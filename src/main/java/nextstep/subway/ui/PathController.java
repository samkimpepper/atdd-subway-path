package nextstep.subway.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nextstep.subway.applicaion.PathService;
import nextstep.subway.applicaion.dto.PathRequest;
import nextstep.subway.applicaion.dto.PathResponse;

@RestController
public class PathController {

	private PathService pathService;

	public PathController(PathService pathService) {
		this.pathService = pathService;
	}

	@GetMapping("/paths")
	public ResponseEntity<PathResponse> getPath(@RequestParam Long source, @RequestParam Long target) {
		PathResponse pathResponse = pathService.getPath(new PathRequest(source, target));
		return ResponseEntity.ok(pathResponse);
	}
}
