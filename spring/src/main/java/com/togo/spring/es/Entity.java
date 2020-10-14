package com.togo.spring.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 6:18 下午 2020/6/26
 **/
///app/kibana#/home?_g=()
@Document(indexName = "drd_dws_fin_hemostasis_plan_contract_f_d", indexStoreType = "entity")
public class Entity {

    @Id
    private String hire_contract_code;
    private String house_source_code;

    public String getHire_contract_code() {
        return hire_contract_code;
    }

    public void setHire_contract_code(String hire_contract_code) {
        this.hire_contract_code = hire_contract_code;
    }

    public String getHouse_source_code() {
        return house_source_code;
    }

    public void setHouse_source_code(String house_source_code) {
        this.house_source_code = house_source_code;
    }
}
