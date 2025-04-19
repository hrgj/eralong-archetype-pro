#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * <p>
 * 车队是相对于外部承运商车队来说，可以理解为公司自营的车队,一个租户下数据状态为10的车队编码只能有一个
 * </p>
 *
 * @author system
 * @since 2025-04-20
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("truck_fleet_inner")
public class TruckFleetInner implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 通过架构组提供的有序自增的，且全局唯一的ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 承运商名称
     */
    private String fleetName;

    /**
     * 承运商编码
     */
    private String fleetCode;

    /**
     * 承运商简称
     */
    private String fleetShortName;

    /**
     * 承运商所在省编码
     */
    private String fleetProvinceCode;

    /**
     * 承运商所在省名称
     */
    private String fleetProvinceName;

    /**
     * 承运商所在市编码
     */
    private String fleetCityCode;

    /**
     * 承运商所在市名称
     */
    private String fleetCityName;

    /**
     * 所属省区编码
     */
    private String provinceAreaCode;

    /**
     * 所属省区名称
     */
    private String provinceAreaName;

    /**
     * 生效状态
     */
    private Integer effectiveStatus;

    /**
     * 状态变更原因
     */
    private String changeReason;

    /**
     * 车队类型
     */
    private String fleetType;

    /**
     * 承运商负责人
     */
    private String fleetManagerName;

    /**
     * 承运商负责人电话
     */
    private String fleetManagerCellphone;

    /**
     * 承运商负责人电话密文
     */
    private String fleetManagerCellphoneSec;

    /**
     * 承运商邮箱
     */
    private String fleetEmail;

    /**
     * 承运商统一社会信用代码,本字段基本不更新
     */
    private String unifiedSocialCreditCode;

    /**
     * 车队内外部标记,10=自营车队，20=外部车队（承运商），在这个表里是固定值10
     */
    private Integer outerInnerTag;

    /**
     * 银行账户信息的关联GUID,新增后基本不更新的
     */
    private String bankAssociationGuid;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人工号
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUserCode;

    /**
     * 创建人姓名
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUserName;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

    /**
     * 更新人工号
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifyUserCode;

    /**
     * 更新人姓名
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifyUserName;

    /**
     * 创建网点编号
     */
    @TableField(fill = FieldFill.INSERT)
    private String createSiteCode;

    /**
     * 创建网点名称
     */
    @TableField(fill = FieldFill.INSERT)
    private String createSiteName;

    /**
     * 更新网点编号
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifySiteCode;

    /**
     * 更新网点名称
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifySiteName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 版本号
     */
    @Version
    private LocalDateTime dataVersion;

    /**
     * 租户号
     */
    private String tenantId;

    /**
     * 数据状态 10=正常;20=删除
     */
    @TableLogic
    private Integer dataStatus;
}
