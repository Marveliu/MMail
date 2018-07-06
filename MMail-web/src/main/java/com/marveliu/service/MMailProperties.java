package com.marveliu.service;
/*
 * Copyright [2018] [Marveliu]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Marveliu
 * @since 2018/6/20
 **/

@Component
public class MMailProperties {

    @Value("${com.marveliu.mmail.name}")
    private String name;
    @Value("${com.marveliu.mmail.title}")
    private String title;
    @Value("${com.marveliu.mmail.desc}")
    private String desc;


    @Value("${com.marveliu.mmail.value}")
    private String value;
    @Value("${com.marveliu.mmail.number}")
    private Integer number;
    @Value("${com.marveliu.mmail.bignumber}")
    private Long bignumber;
    @Value("${com.marveliu.mmail.test1}")
    private Integer test1;
    @Value("${com.marveliu.mmail.test2}")
    private Integer test2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public Integer getTest1() {
        return test1;
    }

    public void setTest1(Integer test1) {
        this.test1 = test1;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }
}
