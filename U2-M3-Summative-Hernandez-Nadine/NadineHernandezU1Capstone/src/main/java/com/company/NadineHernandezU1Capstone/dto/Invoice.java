package com.company.NadineHernandezU1Capstone.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {
    private Integer invoice_id;
    @NotEmpty(message = "name cannot be empty")
    @Size(max = 80, message = "name must be less than 80 characters")
    private String name;
    @NotEmpty(message = "street cannot be empty")
    @Size(max = 30, message = "street must be less than 30 characters")
    private String street;
    @NotEmpty(message = "city cannot be empty")
    @Size(max = 30, message = "city must be less than 30 characters")
    private String city;
    @NotEmpty(message = "state cannot be empty")
    @Size(max = 30, message = "state must be less than 30 characters")
    private String state;
    @NotEmpty(message = "zipcode cannot be empty")
    @Size(max = 5, message = "zipcode must be less than 5 characters")
    private String zipcode;
    @NotEmpty(message = "item_type cannot be empty")
    @Size(max = 20, message = "item_type must be less than 20 characters")
    private String item_type;
    @NotNull(message = "item id cannot be null")
    @Min(value = 0, message = "item id must be greater than 0")
    private Integer item_id;
    private BigDecimal unit_price;
    @NotNull(message = "Quantity cannot be null")
    @Min(value = 0, message = "Quantity must be greater than 0")
    private Integer quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processing_fee;
    private BigDecimal total;

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(BigDecimal processing_fee) {
        this.processing_fee = processing_fee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoice_id, invoice.invoice_id) &&
                name.equals(invoice.name) &&
                street.equals(invoice.street) &&
                city.equals(invoice.city) &&
                state.equals(invoice.state) &&
                zipcode.equals(invoice.zipcode) &&
                item_type.equals(invoice.item_type) &&
                item_id.equals(invoice.item_id) &&
                Objects.equals(unit_price, invoice.unit_price) &&
                quantity.equals(invoice.quantity) &&
                Objects.equals(subtotal, invoice.subtotal) &&
                Objects.equals(tax, invoice.tax) &&
                Objects.equals(processing_fee, invoice.processing_fee) &&
                Objects.equals(total, invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_id, name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total);
    }
}
