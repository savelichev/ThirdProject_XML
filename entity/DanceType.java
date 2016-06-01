
package entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "danceType")
@XmlEnum
public enum DanceType {

    @XmlEnumValue("ballroom")
    BALLROOM("ballroom"),
    @XmlEnumValue("street")
    STREET("street"),
    @XmlEnumValue("ballet")
    BALLET("ballet"),
    @XmlEnumValue("latinos")
    LATINOS("latinos"),
    @XmlEnumValue("folk")
    FOLK("folk");
    private final String value;

    DanceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DanceType fromValue(String v) {
        for (DanceType c: DanceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
