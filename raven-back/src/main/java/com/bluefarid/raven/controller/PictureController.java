package com.bluefarid.raven.controller;

import com.bluefarid.raven.domain.PictureType;
import com.bluefarid.raven.service.PictureUploaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Controller class for handling picture upload requests.
 * This class is responsible for handling picture upload related operations.
 * @author Farid Masjedi
 */
@RestController
@RequestMapping("/api/picture")
@RequiredArgsConstructor
public class PictureController {

    private final PictureUploaderService pictureUploader;

    /**
     * Handles the POST request for uploading a picture.
     *
     * @param file The picture file to be uploaded.
     * @param type The type of the picture.
     * @return ResponseEntity with a BaseResponseDto containing a success message and
     * the uploaded picture's information if the upload is successful,
     * or a BaseResponseDto containing an error message if it fails.
     */
    @PostMapping
    public ResponseEntity<String> uploadPicture(@RequestBody MultipartFile file,
                                                                 @RequestParam PictureType type) {
        try {
            // Create a success response containing the uploaded picture's information
            String response = pictureUploader.uploadPicture(file, type);

            // Return the response entity with the success response
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            // If there is an IOException during the upload process, create an error response
            String errorDto = "Failed to upload picture";

            // Return the response entity with the error response and INTERNAL_SERVER_ERROR status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
        }
    }
}
