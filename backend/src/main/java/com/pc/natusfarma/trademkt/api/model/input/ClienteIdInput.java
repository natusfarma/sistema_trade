package com.pc.natusfarma.trademkt.api.model.input;

public class ClienteIdInput {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClienteIdInput{" +
                "id=" + id +
                '}';
    }
}
