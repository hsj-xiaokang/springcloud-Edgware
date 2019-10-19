package cn.hsj.common.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.hsj.common.entity.AtsTest;
import cn.hsj.common.mapper.AtsTestMapper;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hsj
 * @since 2019-10-18
 */
@Service
public class AtsTestServiceImpl extends ServiceImpl<AtsTestMapper, AtsTest> implements IAtsTestService {
	
}
