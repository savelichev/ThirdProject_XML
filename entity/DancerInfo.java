
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dancerInfo", propOrder = {
    "dancer"
})
public class DancerInfo {

    @XmlElement(required = true)
    protected List<String> dancer =new ArrayList<String>();

    public List<String> getDancer() {

        return dancer;
    }

}
