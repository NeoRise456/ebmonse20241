package org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202110237.ebmonse20241.personnel.domain.services.ExaminerQueryService;
import org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.resources.ExaminerResource;
import org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.u202110237.ebmonse20241.personnel.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/examiners", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Examiners", description = "Examiners Management Endpoints")
public class ExaminersController {
    private final ExaminerQueryService examinerQueryService;
    private final ExaminerCommandService examinerCommandService;

    public ExaminersController(ExaminerQueryService examinerQueryService, ExaminerCommandService examinerCommandService){
        this.examinerQueryService = examinerQueryService;
        this.examinerCommandService = examinerCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new examiner" , description = "Create a new examiner in the system")
    @ApiResponse(responseCode = "201", description = "Examiner created")
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource){
        var createExaminerCommand = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);

        var examinerId = this.examinerCommandService.handle(createExaminerCommand);

        if (examinerId.equals(0L)){
            return ResponseEntity.badRequest().build();
        }
        var getExaminerByIdQuery = new GetExaminerByIdQuery(examinerId);

        var examiner = this.examinerQueryService.handle(getExaminerByIdQuery);

        if (examiner.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner.get());

        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }

}
