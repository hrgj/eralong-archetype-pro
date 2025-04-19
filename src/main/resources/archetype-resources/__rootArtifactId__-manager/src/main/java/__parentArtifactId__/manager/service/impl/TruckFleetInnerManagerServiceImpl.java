#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.manager.service.impl;

import ${package}.${parentArtifactId}.dao.entity.TruckFleetInner;
import ${package}.${parentArtifactId}.dao.mapper.TruckFleetInnerMapper;
import ${package}.${parentArtifactId}.manager.service.TruckFleetInnerManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个 服务实现类
 * </p>
 *
 * @author system
 * @since 2025-04-20
 */
@Service
public class TruckFleetInnerManagerServiceImpl extends ServiceImpl<TruckFleetInnerMapper, TruckFleetInner> implements TruckFleetInnerManagerService {

}
