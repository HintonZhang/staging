package com.hinton.staging.test.controller;

import com.hinton.staging.test.adapter.OutCollection;
import com.hinton.staging.test.adapter.OutTest;
import com.hinton.staging.test.services.CollectionServices;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hinton.staging.adapter.OutError;
@RestController
@Slf4j
@Api(value = "测试", tags = "test")
public class TestController {
    @Autowired
    private CollectionServices collectionServices;

    @ApiOperation(value = "测试接口信息", produces = "application/json",notes = "asset_add")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功", response = OutCollection.class),
            @ApiResponse(code = 400, message = "参数不正确", response = OutError.class)

    })
    @RequestMapping(path = "/test/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> postAsset(@ApiParam(value = "id", required = true) @PathVariable Long id){
            return ResponseEntity.ok(collectionServices.getCollectionById(id));

    }
}
