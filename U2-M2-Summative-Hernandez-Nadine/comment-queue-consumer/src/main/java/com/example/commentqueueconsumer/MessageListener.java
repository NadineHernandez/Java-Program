package com.example.commentqueueconsumer;

import com.example.commentqueueconsumer.util.feign.CommentClient;
import com.example.commentqueueconsumer.util.message.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class MessageListener {

    @Autowired
    CommentClient feignClient;

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(Comment msg){
        if (msg.getCommentId() == 0) {
            feignClient.createComment(msg);
        } else {
            feignClient.updateComment(msg);
        }
    }
}
