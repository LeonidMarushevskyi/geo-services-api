
/**
 * @author CWDS CALS API Team
 */
@TypeDefs(
    value = {
        @TypeDef(
            name = "ChildDesiredJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.ChildDesiredDTO"
                )
            }
        ),
        @TypeDef(
            name = "RFA1cFormJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1cFormDTO"
                )
            }
        ),
        @TypeDef(
            name = "RFA1bFormJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.RFA1bFormDTO"
                )
            }
        ),
        @TypeDef(
            name = "ApplicantHistoryJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantsHistoryDTO"
                )
            }
        ),
        @TypeDef(
            name = "OtherAdultJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.OtherAdultDTO"
                )
            }
        ),
        @TypeDef(
            name = "ApplicationJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicationDTO"
                )
            }
        ),
        @TypeDef(
            name = "ApplicantJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantDTO"
                )
            }
        ),
        @TypeDef(
            name = "ResidenceJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.ResidenceDTO"
                )
            }
        ),
        @TypeDef(
            name = "ApplicantsRelationshipJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantsRelationshipDTO"
                )
            }
        ),
        @TypeDef(
            name = "MinorChildJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.MinorChildDTO"
                )
            }
        ),
        @TypeDef(
            name = "AdoptionHistoryJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.AdoptionHistoryDTO"
                )
            }
        ),
        @TypeDef(
            name = "ReferencesJsonType",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.ReferencesDTO"
                )
            }
        ),
        @TypeDef(
            name = "ApplicantsDeclaration",
            typeClass = JsonType.class,
            parameters = {
                @Parameter(name = SQL_TYPE, value = SQLTypes.CLOB_TYPE_NAME),
                @Parameter(
                    name = RETURNED_CLASS_NAME_PARAM,
                    value = "gov.ca.cwds.cals.persistence.model.calsns.rfa.ApplicantsDeclarationDTO"
                )
            }
        )
    }
)
package gov.ca.cwds.cals.persistence.model.calsns.rfa;

import static gov.ca.cwds.cals.Constants.RETURNED_CLASS_NAME_PARAM;
import static gov.ca.cwds.cals.Constants.SQL_TYPE;

import gov.ca.cwds.cals.persistence.hibernate.JsonType;
import gov.ca.cwds.cals.persistence.hibernate.SQLTypes;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
