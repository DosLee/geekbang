package org.geek.rpcfx;

import org.geek.rpcfx.api.RpcfxRequest;
import org.geek.rpcfx.api.RpcfxResolver;
import org.geek.rpcfx.api.RpcfxResponse;
import org.geek.rpcfx.server.RpcfxInvoker;
import org.geek.rpcfx.service.OrderService;
import org.geek.rpcfx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RpcfxServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RpcfxServerApplication.class, args);
	}

	@Autowired
	RpcfxInvoker invoker;

	@PostMapping("/")
	public RpcfxResponse invoke(@RequestBody RpcfxRequest request) {
		return invoker.invoke(request);
	}

	@Bean
	public RpcfxInvoker createInvoker(@Autowired RpcfxResolver resolver){
		return new RpcfxInvoker(resolver);
	}

	@Bean
	public RpcfxResolver createResolver(){
		return new RpcResolver();
	}

	@Bean(name = "org.geek.rpcfx.service.UserService")
	public UserService createUserService(){
		return new UserServiceImpl();
	}

	@Bean(name = "org.geek.rpcfx.service.OrderService")
	public OrderService createOrderService(){
		return new OrderServiceImpl();
	}

}
