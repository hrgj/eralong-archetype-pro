#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.model.request;

import ${package}.base.page.BaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
* <p>
* 车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个请求参数
* </p>
*
* @author system
* @since 2025-04-20
*/
@Data
@Schema(name = "TruckFleetInnerRequest", description = "车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个请求参数")
public class TruckFleetInnerRequest extends BaseRequest {


    @Schema(description = "通过架构组提供的有序自增的，且全局唯一的ID")
    private Long id;
    @Schema(description = "承运商名称")
    private String fleetName;
    @Schema(description = "承运商编码")
    private String fleetCode;
    @Schema(description = "承运商简称")
    private String fleetShortName;
    @Schema(description = "承运商所在省编码")
    private String fleetProvinceCode;
    @Schema(description = "承运商所在省名称")
    private String fleetProvinceName;
    @Schema(description = "承运商所在市编码")
    private String fleetCityCode;
    @Schema(description = "承运商所在市名称")
    private String fleetCityName;
    @Schema(description = "所属省区编码")
    private String provinceAreaCode;
    @Schema(description = "所属省区名称")
    private String provinceAreaName;
    @Schema(description = "生效状态")
    private Integer effectiveStatus;
    @Schema(description = "状态变更原因")
    private String changeReason;
    @Schema(description = "车队类型")
    private String fleetType;
    @Schema(description = "承运商负责人")
    private String fleetManagerName;
    @Schema(description = "承运商负责人电话")
    private String fleetManagerCellphone;
    @Schema(description = "承运商负责人电话密文")
    private String fleetManagerCellphoneSec;
    @Schema(description = "承运商邮箱")
    private String fleetEmail;
    @Schema(description = "承运商统一社会信用代码,本字段基本不更新")
    private String unifiedSocialCreditCode;
    @Schema(description = "车队内外部标记,10=自营车队，20=外部车队（承运商），在这个表里是固定值10")
    private Integer outerInnerTag;
    @Schema(description = "银行账户信息的关联GUID,新增后基本不更新的")
    private String bankAssociationGuid;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "创建人工号")
    private String createUserCode;
    @Schema(description = "创建人姓名")
    private String createUserName;
    @Schema(description = "更新时间")
    private LocalDateTime modifyTime;
    @Schema(description = "更新人工号")
    private String modifyUserCode;
    @Schema(description = "更新人姓名")
    private String modifyUserName;
    @Schema(description = "创建网点编号")
    private String createSiteCode;
    @Schema(description = "创建网点名称")
    private String createSiteName;
    @Schema(description = "更新网点编号")
    private String modifySiteCode;
    @Schema(description = "更新网点名称")
    private String modifySiteName;
    @Schema(description = "备注")
    private String remark;
    @Schema(description = "版本号")
    private LocalDateTime dataVersion;
    @Schema(description = "租户号")
    private String tenantId;
    @Schema(description = "数据状态 10=正常;20=删除")
    private Integer dataStatus;

}