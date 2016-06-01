
package entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "musicType")
@XmlEnum
public enum MusicType {

    @XmlEnumValue("phonogram")
    PHONOGRAM("phonogram"),
    @XmlEnumValue("live")
    LIVE("live");
    private final String value;

    MusicType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MusicType fromValue(String v) {
        for (MusicType c: MusicType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
