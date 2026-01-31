package com.fbp.lambdaclient;

// Source - https://stackoverflow.com/a/41634244
// Posted by user7401700, modified by community. See post 'Timeline' for change history
// Retrieved 2026-01-30, License - CC BY-SA 3.0

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaAsync;
import com.amazonaws.services.lambda.AWSLambdaAsyncClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

public class LambdaClient {

    public void runWithoutPayload(String region, String functionName) {
        runWithPayload(region, functionName, null);
    }

    public void runWithPayload(String region, String functionName, String payload) {
        AWSLambdaAsync client = AWSLambdaAsyncClientBuilder.standard()
            .withRegion(Regions.fromName(region))
            .build();
        InvokeRequest request = new InvokeRequest()
            .withInvocationType("RequestResponse")
            .withFunctionName(functionName)
            .withPayload(payload);
        System.out.println("Invoking " + functionName + " with payload " + payload);
        System.out.println("Request: " + request);    
        InvokeResult invoke = client.invoke(request);
        System.out.println("Result invoking " + functionName + ": " + invoke.toString());
    }
}
