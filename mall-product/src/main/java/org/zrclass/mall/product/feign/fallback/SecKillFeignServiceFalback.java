package org.zrclass.mall.product.feign.fallback;

import org.springframework.stereotype.Component;
import org.zrclass.common.exception.BizCodeEnum;
import org.zrclass.common.utils.R;
import org.zrclass.mall.product.feign.SeckillFeignService;

/**
 * <p>Title: SecKillFeignServiceFalback</p>
 * Description：
 * date：2020/7/10 16:03
 */
@Component
public class SecKillFeignServiceFalback implements SeckillFeignService {

	@Override
	public R getSkuSeckillInfo(Long skuId) {
		System.out.println("触发熔断");
		return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMsg());
	}
}
