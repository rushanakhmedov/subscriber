package com.example.subscriber.controller;

import com.example.subscriber.dto.MessageDTO;
import com.example.subscriber.service.MessageService;
import com.example.subscriber.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    Logger logger = LoggerFactory.getLogger(MessageController.class);

    private MessageService messageService;
    private ResponseService responseService;

    @Autowired
    public MessageController(MessageService messageService, ResponseService responseService) {
        this.messageService = messageService;
        this.responseService = responseService;
    }

    @PostMapping
    public ResponseEntity message(@RequestBody @Valid MessageDTO message, BindingResult validationResult) {
        logger.info("message method");
        if (validationResult.hasErrors()) {
            logger.info("validation error");
            Map<String, String> errors = responseService.convertErrors(validationResult);
            return new ResponseEntity<Object>(errors, HttpStatus.CONFLICT);
        }
        logger.info("validation ok");
        messageService.saveMessage(message);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
