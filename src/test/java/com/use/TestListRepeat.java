package com.use;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;

public class TestListRepeat {
    
    @Test
    public void test() {
        ArrayList<String> allTables = Lists.newArrayList("account_history", "account_info", "appointment", "case_img", "customer_info", "doctor", "email_send_log", "email_template", "oa_notification", "oss_attachment", "pay_notify", "pay_way", "refund_record", "scheme", "sms_send_log", "sms_template", "sys_data_source", "sys_dict", "sys_dict_group", "sys_login_log", "sys_menu", "sys_message", "sys_message_template", "sys_operation_log", "sys_organization", "sys_role", "sys_role_menu", "sys_sessions", "sys_user", "sys_user_organization", "sys_user_role", "task_schedule_job", "task_schedule_job_log", "trade_payment_order", "trade_payment_record", "users");
        ArrayList<String> partTables = Lists.newArrayList("account_history", "account_info", "appointment", "case_img", "customer_info", "doctor", "oa_notification", "pay_notify", "pay_way", "refund_record", "scheme", "sms_send_log", "sms_template", "sys_data_source", "sys_menu", "sys_operation_log", "sys_organization", "sys_role", "sys_role_menu", "sys_sessions", "sys_user", "sys_user_organization", "sys_user_role", "task_schedule_job", "task_schedule_job_log", "trade_payment_order", "trade_payment_record", "users");
        allTables.removeAll(partTables);
        allTables.stream().forEach(table ->{
            System.out.println(table);
        });
    }
}
