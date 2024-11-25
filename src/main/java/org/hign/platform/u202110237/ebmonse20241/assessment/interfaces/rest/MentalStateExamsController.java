package org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.model.queries.GetMentalStateExamByIdQuery;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202110237.ebmonse20241.assessment.domain.services.MentalStateExamQueryService;
import org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.transform.CreateMentalStateExamCommandFromResourceAssembler;
import org.hign.platform.u202110237.ebmonse20241.assessment.interfaces.rest.transform.MentalStateExamResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * MentalStateExamsController
 * @author Juan Astonitas
 */
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/mental-state-exams", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exams", description = "Mental State Exams Management Endpoints")
public class MentalStateExamsController {

    private final MentalStateExamQueryService mentalStateExamQueryService;
    private final MentalStateExamCommandService mentalStateExamCommandService;

    /**
     * Constructor
     * @param mentalStateExamQueryService
     * @param mentalStateExamCommandService
     * @Author Juan Astonitas
     */
    public MentalStateExamsController(MentalStateExamQueryService mentalStateExamQueryService, MentalStateExamCommandService mentalStateExamCommandService) {
        this.mentalStateExamQueryService = mentalStateExamQueryService;
        this.mentalStateExamCommandService = mentalStateExamCommandService;
    }

    /**
     * Create a new mental state exam
     * @param resource
     * @return ResponseEntity<MentalStateExamResource>
     *     * @see MentalStateExamResource
     *     * @see CreateMentalStateExamResource
     *     * @see CreateMentalStateExamCommandFromResourceAssembler
     *     * @see MentalStateExamResourceFromEntityAssembler
     *     * @see GetMentalStateExamByIdQuery
     * @author Juan Astonitas
     */
    @PostMapping
    @Operation(summary = "Create a new mental state exam" , description = "Create a new mental state exam in the system")
    @ApiResponse(responseCode = "201", description = "Mental state exam created")
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource resource) {

        var createMentalStateExamCommand = CreateMentalStateExamCommandFromResourceAssembler.toCommandFromResoruce(resource);

        var mentalStateExamId = this.mentalStateExamCommandService.handle(createMentalStateExamCommand);

        if (mentalStateExamId.equals(0L)) {
            return ResponseEntity.badRequest().build();
        }
        var getMentalStateExamByIdQuery = new GetMentalStateExamByIdQuery(mentalStateExamId);

        var mentalStateExam = this.mentalStateExamQueryService.handle(getMentalStateExamByIdQuery);

        if (mentalStateExam.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var mentalStateExamResource = MentalStateExamResourceFromEntityAssembler.toResoruceFromEntity(mentalStateExam.get());

        return new ResponseEntity<>(mentalStateExamResource, HttpStatus.CREATED);


    }

}
