#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 站点类型
 */
@Getter
public enum StationTypeEnum {

    DISTRIBUTION(10,"分拨"),

    OUTLETS(20,"网点"),

    CENTRALIZED_REFUELING_POINTS(30,"集中加油点")
    ;

    private final Integer code;

    private final String name;

    StationTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<Integer, String> CODE_TO_NAME =
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            StationTypeEnum::getCode,
                            StationTypeEnum::getName
                    ));

    public static String getNameByCode(Integer code) {
        return CODE_TO_NAME.getOrDefault(code, "未知站点类型");
    }
}
