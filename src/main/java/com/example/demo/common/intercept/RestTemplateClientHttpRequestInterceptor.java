package com.example.demo.common.intercept;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestTemplateClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @NonNull
    @Override
    public ClientHttpResponse intercept(@NonNull final HttpRequest request
                                        , @NonNull final byte[] body
                                        , final @NonNull ClientHttpRequestExecution execution) throws IOException {

        logRequest(request, body);

        final ClientHttpResponse response = execution.execute(request, body);

        logResponse(response, request.getURI());

        return response;
    }
    /** 
     * <pre> 
     * RestTemplate Request 로깅 
     * 
     * <pre> 
     * @param request HttpRequest 
     * @param body Request Body 
     */ 
    private void logRequest(HttpRequest request, byte[] body) { 
        StringBuilder reqLog = new StringBuilder(); 
        reqLog.append("\n[REQUEST URI] ")
              .append(request.getURI()) 
              .append("\n[REQUEST Method] ")
              .append(request.getMethod());
              //body는 Stream 이므로 한번 읽으면 다시 읽지 못한다.
              //.append("\n[REQUEST Body] ")
              //.append(new String(body, StandardCharsets.UTF_8)); 
        
        log.debug(reqLog.toString()); 
    } 
    
    /** 
     * <pre> 
     * RestTemplate Response 로깅 
     * 
     * <pre> 
     * @param response ClientHttpResponse 
     * @throws IOException 
     */ 
    private void logResponse(ClientHttpResponse response, URI uri) throws IOException { 
        StringBuilder resLog = new StringBuilder(); 
        resLog.append("\n[RESPONSE URI] ")
              .append(uri) 
              .append("\n[RESPONSE Status code] ")
              .append(response.getStatusCode());
              //body는 Stream 이므로 한번 읽으면 다시 읽지 못한다.
              //.append("\n[RESPONSE Response Body] ")
              //.append(StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8)); 
        
        log.debug(resLog.toString()); 
    }

}