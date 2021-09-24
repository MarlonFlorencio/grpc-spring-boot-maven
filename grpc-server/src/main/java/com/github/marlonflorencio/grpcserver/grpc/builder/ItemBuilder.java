package com.github.marlonflorencio.grpcserver.grpc.builder;

import com.github.marlonflorencio.grpcserver.domain.model.Item;
import com.github.marlonflorencio.grpclib.proto.ItemDTO;

import java.util.ArrayList;

import static com.github.marlonflorencio.grpclib.util.ProtoDateUtil.toOffsetDateTime;
import static com.github.marlonflorencio.grpclib.util.ProtoDateUtil.toTimestamp;
import static com.github.marlonflorencio.grpclib.util.ProtoDecimalUtil.toBigDecimal;
import static com.github.marlonflorencio.grpclib.util.ProtoDecimalUtil.toDecimalValue;

public class ItemBuilder {

    public static Item toModel(ItemDTO dto) {
        return Item.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(toBigDecimal(dto.getPrice()))
                .quantity(dto.getQuantity())
                .categories(new ArrayList<>(dto.getCategoriesList()))
                .createdAt(toOffsetDateTime(dto.getCreatedAt()))
                .build();
    }

    public static ItemDTO toDTO(Item item) {
        return ItemDTO.newBuilder()
                .setId(item.getId())
                .setTitle(item.getTitle())
                .setDescription(item.getDescription())
                .setPrice(toDecimalValue(item.getPrice()))
                .setQuantity(item.getQuantity())
                .addAllCategories(item.getCategories())
                .setCreatedAt(toTimestamp(item.getCreatedAt()))
                .build();
    }

}
