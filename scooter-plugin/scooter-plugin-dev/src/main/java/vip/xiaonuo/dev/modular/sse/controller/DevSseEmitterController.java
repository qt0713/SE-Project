
package vip.xiaonuo.dev.modular.sse.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import vip.xiaonuo.common.sse.CommonSseParam;
import vip.xiaonuo.dev.modular.sse.service.DevSseEmitterService;

import java.util.function.Consumer;

/**
 * SSE通信控制器
 *
 * @author diantu
 * @date 2023/7/3
 **/
@Tag(name = "SSE通信控制器")
@RestController
@Validated
public class DevSseEmitterController {

    @Resource
    private DevSseEmitterService devSseEmitterService;

    /**
     * 创建sse连接
     *
     * @author diantu
     * @date 2023/7/3
     **/
    @Operation(summary = "创建sse连接")
    @GetMapping("/dev/sse/createConnect")
    public SseEmitter createConnect(String clientId,
                                    @RequestParam(required = false)Boolean setHeartBeat,
                                    @RequestParam(required = false)Boolean defaultHeartbeat,
                                    @RequestParam(required = false)Consumer<CommonSseParam> consumer){
        return devSseEmitterService.createSseConnect(clientId,setHeartBeat,defaultHeartbeat,consumer);
    }

    /**
     * 关闭sse连接
     *
     * @author diantu
     * @date 2023/7/3
     **/
    @Operation(summary = "关闭sse连接")
    @GetMapping("/dev/sse/closeSseConnect")
    public void closeSseConnect(String clientId){
        devSseEmitterService.closeSseConnect(clientId);
    }

    /**
     * 推送消息到所有客户端
     *
     * @author diantu
     * @date 2023/7/3
     **/
    @Operation(summary = "推送消息到所有客户端")
    @PostMapping("/dev/sse/broadcast")
    public void sendMessageToAllClient(@RequestBody(required = false) String msg){
        devSseEmitterService.sendMessageToAllClient(msg);
    }

    /**
     * 根据clientId发送消息给某一客户端
     *
     * @author diantu
     * @date 2023/7/3
     **/
    @Operation(summary = "根据clientId发送消息给某一客户端")
    @PostMapping("/dev/sse/sendMessage")
    public void sendMessageToOneClient(String clientId,String msg){
        devSseEmitterService.sendMessageToOneClient(clientId,msg);
    }

}
