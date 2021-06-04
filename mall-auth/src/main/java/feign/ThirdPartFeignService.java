package feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zrclass.common.utils.R;

/**
 * <p>Title: ThirdPartFeignService</p>
 * Description：
 * date：2020/6/25 15:01
 */
@FeignClient("mall-third-party")
public interface ThirdPartFeignService {

	@GetMapping("/sms/sendcode")
	R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);
}
