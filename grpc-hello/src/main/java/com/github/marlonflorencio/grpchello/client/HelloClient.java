package com.github.marlonflorencio.grpchello.client;


import com.github.marlonflorencio.grpclib.proto.HelloRequest;
import com.github.marlonflorencio.grpclib.proto.HelloResponse;
import com.github.marlonflorencio.grpclib.proto.HelloServiceGrpc;
import com.github.marlonflorencio.grpclib.proto.HelloServiceGrpc.HelloServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {

    public static void main(String[] args) {
        System.out.println("Hello gRPC client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        HelloServiceBlockingStub client = HelloServiceGrpc.newBlockingStub(channel);

        sayHello(client);

        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    private static void sayHello(HelloServiceBlockingStub client) {

        HelloRequest requestPayload = HelloRequest.newBuilder()
                .setName("John")
                .build();

        HelloResponse response = client.sayHello(requestPayload);

        System.out.println(response.getResult());
    }

}
