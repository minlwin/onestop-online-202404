package com.jdc.spring.controller.dto.output;

import java.time.LocalDateTime;

import com.jdc.spring.model.entity.Account;

public record AccountDetails(
		int id,
		String name, 
		String email,
		String profileImage,
		boolean disabled,
		LocalDateTime createdAt,
		String createdBy,
		LocalDateTime modifiedAt,
		String modifiedBy) {
	
	public static AccountDetails from(Account entity) {
        return AccountDetails.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .profileImage(entity.getProfileImage())
                .disabled(entity.isDisabled())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .modifiedAt(entity.getModifiedAt())
                .modifiedBy(entity.getModifiedBy())
                .build();	
    }

	public static Builder builder() {
		return new Builder();
	}
	
    public static class Builder {
        private int id;
        private String name;
        private String email;
        private String profileImage;
        private boolean disabled;
        private LocalDateTime createdAt;
        private String createdBy;
        private LocalDateTime modifiedAt;
        private String modifiedBy;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder profileImage(String profileImage) {
            this.profileImage = profileImage;
            return this;
        }

        public Builder disabled(boolean disabled) {
            this.disabled = disabled;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder modifiedAt(LocalDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public Builder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AccountDetails build() {
            return new AccountDetails(id, name, email, profileImage, disabled, createdAt, createdBy, modifiedAt, modifiedBy);
        }
    }
    
}
