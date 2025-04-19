#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.service.service;

import ${package}.base.page.BasePageVO;
import ${package}.${parentArtifactId}.model.vo.TruckFleetInnerVO;
import ${package}.${parentArtifactId}.model.request.TruckFleetInnerRequest;

/**
 * <p>
 * 车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个 服务类
 * </p>
 *
 * @author system
 * @since 2025-04-20
 */
public interface TruckFleetInnerService  {
    Boolean create(TruckFleetInnerRequest request);
    Boolean delete(Long id);
    Boolean updateById(TruckFleetInnerRequest request);
    TruckFleetInnerVO getTruckFleetInnerById(TruckFleetInnerRequest request);
    BasePageVO<TruckFleetInnerVO> page(TruckFleetInnerRequest request);
}
