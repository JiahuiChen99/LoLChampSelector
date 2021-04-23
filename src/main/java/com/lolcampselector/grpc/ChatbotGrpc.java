package com.lolcampselector.grpc;

import java.io.FileNotFoundException;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chatapi.proto")
public final class ChatbotGrpc {

  private ChatbotGrpc() {}

  public static final String SERVICE_NAME = "Chatbot";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lolcampselector.grpc.Chatapi.Message,
      com.lolcampselector.grpc.Chatapi.Message> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send_message",
      requestType = com.lolcampselector.grpc.Chatapi.Message.class,
      responseType = com.lolcampselector.grpc.Chatapi.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lolcampselector.grpc.Chatapi.Message,
      com.lolcampselector.grpc.Chatapi.Message> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.lolcampselector.grpc.Chatapi.Message, com.lolcampselector.grpc.Chatapi.Message> getSendMessageMethod;
    if ((getSendMessageMethod = ChatbotGrpc.getSendMessageMethod) == null) {
      synchronized (ChatbotGrpc.class) {
        if ((getSendMessageMethod = ChatbotGrpc.getSendMessageMethod) == null) {
          ChatbotGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<com.lolcampselector.grpc.Chatapi.Message, com.lolcampselector.grpc.Chatapi.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Chatbot", "send_message"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lolcampselector.grpc.Chatapi.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lolcampselector.grpc.Chatapi.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatbotMethodDescriptorSupplier("send_message"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lolcampselector.grpc.Chatapi.EmptyMessge,
      com.lolcampselector.grpc.Chatapi.APIResponse> getGetMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get_message",
      requestType = com.lolcampselector.grpc.Chatapi.EmptyMessge.class,
      responseType = com.lolcampselector.grpc.Chatapi.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lolcampselector.grpc.Chatapi.EmptyMessge,
      com.lolcampselector.grpc.Chatapi.APIResponse> getGetMessageMethod() {
    io.grpc.MethodDescriptor<com.lolcampselector.grpc.Chatapi.EmptyMessge, com.lolcampselector.grpc.Chatapi.APIResponse> getGetMessageMethod;
    if ((getGetMessageMethod = ChatbotGrpc.getGetMessageMethod) == null) {
      synchronized (ChatbotGrpc.class) {
        if ((getGetMessageMethod = ChatbotGrpc.getGetMessageMethod) == null) {
          ChatbotGrpc.getGetMessageMethod = getGetMessageMethod = 
              io.grpc.MethodDescriptor.<com.lolcampselector.grpc.Chatapi.EmptyMessge, com.lolcampselector.grpc.Chatapi.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Chatbot", "get_message"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lolcampselector.grpc.Chatapi.EmptyMessge.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lolcampselector.grpc.Chatapi.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatbotMethodDescriptorSupplier("get_message"))
                  .build();
          }
        }
     }
     return getGetMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatbotStub newStub(io.grpc.Channel channel) {
    return new ChatbotStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatbotBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatbotBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatbotFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatbotFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatbotImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends user's text input to the server
     * </pre>
     */
    public void sendMessage(com.lolcampselector.grpc.Chatapi.Message request,
        io.grpc.stub.StreamObserver<com.lolcampselector.grpc.Chatapi.Message> responseObserver) throws FileNotFoundException {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sends a response back to the client side
     * </pre>
     */
    public void getMessage(com.lolcampselector.grpc.Chatapi.EmptyMessge request,
        io.grpc.stub.StreamObserver<com.lolcampselector.grpc.Chatapi.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lolcampselector.grpc.Chatapi.Message,
                com.lolcampselector.grpc.Chatapi.Message>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getGetMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.lolcampselector.grpc.Chatapi.EmptyMessge,
                com.lolcampselector.grpc.Chatapi.APIResponse>(
                  this, METHODID_GET_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class ChatbotStub extends io.grpc.stub.AbstractStub<ChatbotStub> {
    private ChatbotStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatbotStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatbotStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatbotStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends user's text input to the server
     * </pre>
     */
    public void sendMessage(com.lolcampselector.grpc.Chatapi.Message request,
        io.grpc.stub.StreamObserver<com.lolcampselector.grpc.Chatapi.Message> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sends a response back to the client side
     * </pre>
     */
    public void getMessage(com.lolcampselector.grpc.Chatapi.EmptyMessge request,
        io.grpc.stub.StreamObserver<com.lolcampselector.grpc.Chatapi.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatbotBlockingStub extends io.grpc.stub.AbstractStub<ChatbotBlockingStub> {
    private ChatbotBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatbotBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatbotBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatbotBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends user's text input to the server
     * </pre>
     */
    public com.lolcampselector.grpc.Chatapi.Message sendMessage(com.lolcampselector.grpc.Chatapi.Message request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sends a response back to the client side
     * </pre>
     */
    public com.lolcampselector.grpc.Chatapi.APIResponse getMessage(com.lolcampselector.grpc.Chatapi.EmptyMessge request) {
      return blockingUnaryCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatbotFutureStub extends io.grpc.stub.AbstractStub<ChatbotFutureStub> {
    private ChatbotFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatbotFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatbotFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatbotFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends user's text input to the server
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lolcampselector.grpc.Chatapi.Message> sendMessage(
        com.lolcampselector.grpc.Chatapi.Message request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sends a response back to the client side
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lolcampselector.grpc.Chatapi.APIResponse> getMessage(
        com.lolcampselector.grpc.Chatapi.EmptyMessge request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_GET_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatbotImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatbotImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          try {
            serviceImpl.sendMessage((Chatapi.Message) request,
                (io.grpc.stub.StreamObserver<Chatapi.Message>) responseObserver);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
          break;
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((com.lolcampselector.grpc.Chatapi.EmptyMessge) request,
              (io.grpc.stub.StreamObserver<com.lolcampselector.grpc.Chatapi.APIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatbotBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatbotBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lolcampselector.grpc.Chatapi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Chatbot");
    }
  }

  private static final class ChatbotFileDescriptorSupplier
      extends ChatbotBaseDescriptorSupplier {
    ChatbotFileDescriptorSupplier() {}
  }

  private static final class ChatbotMethodDescriptorSupplier
      extends ChatbotBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatbotMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatbotGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatbotFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .addMethod(getGetMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
