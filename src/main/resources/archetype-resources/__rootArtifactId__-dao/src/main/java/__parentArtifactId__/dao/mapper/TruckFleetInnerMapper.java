#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${package}.${parentArtifactId}.dao.entity.TruckFleetInner;
import org.apache.ibatis.annotations.Mapper;
import ${package}.${parentArtifactId}.model.request.TruckFleetInnerRequest;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个 Mapper 接口
 * </p>
 *
 * @author system
 * @since 2025-04-20
 */
@Mapper
public interface TruckFleetInnerMapper extends BaseMapper<TruckFleetInner> {

    Boolean updateByIdSelective(TruckFleetInnerRequest request);
    TruckFleetInner selectBySelective(TruckFleetInnerRequest request);
    Page<TruckFleetInner> selectUsePage(@Param("page") Page<TruckFleetInnerRequest> page, @Param("request") TruckFleetInnerRequest request);
}

