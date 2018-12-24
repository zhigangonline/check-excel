package com.use;

import org.owasp.validator.html.*;

import java.util.Optional;

public class AntiSamyXssFilter {

    public static void main(String[] args) {
        AntiSamy as = new AntiSamy();

        try {
            Policy policy = Policy.getInstance("antisamy-ebay.xml");
            CleanResults cr = as.scan("<div>www<script>alert(1)</script></div>", policy);
            Optional.ofNullable(cr.getCleanHTML()).ifPresent(System.out::println);
        } catch (PolicyException e) {
            e.printStackTrace();
        } catch (ScanException e) {
            e.printStackTrace();
        }

    }
}
