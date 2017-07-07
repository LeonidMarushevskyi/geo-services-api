package gov.ca.cwds.cals.persistence.model.lisfas;

import gov.ca.cwds.data.persistence.PersistentObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@javax.persistence.Table(name = "lis_do_file")
public class LisDoFile implements PersistentObject {

    private static final long serialVersionUID = 7632186071372359636L;

    private Integer isnLisDoFile;
    private Integer doNbr;
    private String doName;
    private String doStreetAddr;
    private String doCity;
    private String doState;
    private String doZipCode;
    private String doPhoneNbr;
    private Integer doCalstarsNbr;
    private Integer doUnitCode;
    private String doPrintDest;
    private Integer doRegionNbr;
    private Integer doAccessCode;
    private Integer doBlockBegin;
    private Integer doBlockEnd;
    private Integer doNextFacNbr;

    @Id
    @javax.persistence.Column(name = "isn_lis_do_file", nullable = false)
    public Integer getIsnLisDoFile() {
        return isnLisDoFile;
    }

    public void setIsnLisDoFile(Integer isnLisDoFile) {
        this.isnLisDoFile = isnLisDoFile;
    }

    @Basic
    @javax.persistence.Column(name = "do_nbr", nullable = false)
    public Integer getDoNbr() {
        return doNbr;
    }

    public void setDoNbr(Integer doNbr) {
        this.doNbr = doNbr;
    }

    @Basic
    @javax.persistence.Column(name = "do_name", nullable = true, length = 20)
    public String getDoName() {
        return doName;
    }

    public void setDoName(String doName) {
        this.doName = doName;
    }

    @Basic
    @javax.persistence.Column(name = "do_street_addr", nullable = true, length = 30)
    public String getDoStreetAddr() {
        return doStreetAddr;
    }

    public void setDoStreetAddr(String doStreetAddr) {
        this.doStreetAddr = doStreetAddr;
    }

    @Basic
    @javax.persistence.Column(name = "do_city", nullable = true, length = 20)
    public String getDoCity() {
        return doCity;
    }

    public void setDoCity(String doCity) {
        this.doCity = doCity;
    }

    @Basic
    @javax.persistence.Column(name = "do_state", nullable = true, length = 2)
    public String getDoState() {
        return doState;
    }

    public void setDoState(String doState) {
        this.doState = doState;
    }

    @Basic
    @javax.persistence.Column(name = "do_zip_code", nullable = true, length = 9)
    public String getDoZipCode() {
        return doZipCode;
    }

    public void setDoZipCode(String doZipCode) {
        this.doZipCode = doZipCode;
    }

    @Basic
    @javax.persistence.Column(name = "do_phone_nbr", nullable = true, length = 10)
    public String getDoPhoneNbr() {
        return doPhoneNbr;
    }

    public void setDoPhoneNbr(String doPhoneNbr) {
        this.doPhoneNbr = doPhoneNbr;
    }

    @Basic
    @javax.persistence.Column(name = "do_calstars_nbr", nullable = true)
    public Integer getDoCalstarsNbr() {
        return doCalstarsNbr;
    }

    public void setDoCalstarsNbr(Integer doCalstarsNbr) {
        this.doCalstarsNbr = doCalstarsNbr;
    }

    @Basic
    @javax.persistence.Column(name = "do_unit_code", nullable = true)
    public Integer getDoUnitCode() {
        return doUnitCode;
    }

    public void setDoUnitCode(Integer doUnitCode) {
        this.doUnitCode = doUnitCode;
    }

    @Basic
    @javax.persistence.Column(name = "do_print_dest", nullable = true, length = 6)
    public String getDoPrintDest() {
        return doPrintDest;
    }

    public void setDoPrintDest(String doPrintDest) {
        this.doPrintDest = doPrintDest;
    }

    @Basic
    @javax.persistence.Column(name = "do_region_nbr", nullable = true)
    public Integer getDoRegionNbr() {
        return doRegionNbr;
    }

    public void setDoRegionNbr(Integer doRegionNbr) {
        this.doRegionNbr = doRegionNbr;
    }

    @Basic
    @javax.persistence.Column(name = "do_access_code", nullable = true)
    public Integer getDoAccessCode() {
        return doAccessCode;
    }

    public void setDoAccessCode(Integer doAccessCode) {
        this.doAccessCode = doAccessCode;
    }

    @Basic
    @javax.persistence.Column(name = "do_block_begin", nullable = true)
    public Integer getDoBlockBegin() {
        return doBlockBegin;
    }

    public void setDoBlockBegin(Integer doBlockBegin) {
        this.doBlockBegin = doBlockBegin;
    }

    @Basic
    @javax.persistence.Column(name = "do_block_end", nullable = true)
    public Integer getDoBlockEnd() {
        return doBlockEnd;
    }

    public void setDoBlockEnd(Integer doBlockEnd) {
        this.doBlockEnd = doBlockEnd;
    }

    @Basic
    @javax.persistence.Column(name = "do_next_fac_nbr", nullable = true)
    public Integer getDoNextFacNbr() {
        return doNextFacNbr;
    }

    public void setDoNextFacNbr(Integer doNextFacNbr) {
        this.doNextFacNbr = doNextFacNbr;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    @Override
    @Transient
    public Serializable getPrimaryKey() {
        return getIsnLisDoFile();
    }
}
