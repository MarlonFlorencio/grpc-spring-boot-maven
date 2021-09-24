package com.github.marlonflorencio.grpchello.server;

import com.github.marlonflorencio.grpclib.proto.HelloRequest;
import com.github.marlonflorencio.grpclib.proto.HelloResponse;
import com.github.marlonflorencio.grpclib.proto.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        final String text = "Hello ".concat(request.getName()).concat("!");
        final HelloResponse response = HelloResponse.newBuilder().setResult(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
