# OfflinePay — Secure Offline Payment & Mesh Settlement System

OfflinePay is a Spring Boot project that simulates sending payments when the sender has no internet connection.

The payment is encrypted into a packet, forwarded through simulated phones using a gossip/mesh mechanism, and eventually uploaded by a bridge device with internet access. The backend then validates and settles the payment.

## Features

* Offline payment packet simulation
* Gossip-based mesh forwarding with TTL
* AES-256-GCM encryption
* RSA-2048 OAEP-SHA256 key protection
* SHA-256 packet hashing for duplicate detection
* PIN verification
* 24-hour packet expiry validation
* Insufficient balance checking
* MySQL transaction ledger
* Optimistic locking using JPA `@Version`
* REST APIs and live dashboard
* JUnit 5 + Mockito tests

## Tech Stack

**Java 17 · Spring Boot 3.3.5 · Spring Data JPA · MySQL · Maven · Thymeleaf · JUnit 5 · Mockito**

## How It Works

```text-ARCHITECTURE
Sender
  ↓
Encrypted Payment Packet
  ↓
Phone → Phone → Phone
  ↓
Bridge Device
  ↓
Spring Boot Backend
  ↓
Validate → Deduplicate → Settle
```

# Key **Highlights**

Prevents duplicate settlement using packet hashing + idempotency
Rejects invalid PIN, expired packets and insufficient balance
Uses @Version for -- optimistic locking
Dashboard displays balances, transactions, status and rejection reasons


## Example

A simulated ₹400 payment from `alice@demo` to `bob@demo` can travel through the mesh and reach the backend through `phone-bridge`.

The dashboard shows:

* Account balances
* Transaction status
* Rejection reason
* Bridge node
* Hop count
* Activity logs

## Running Locally

### Requirements

* JDK 17+
* MySQL 8
* Maven Wrapper

Create the database:

CREATE DATABASE offlinepay;

Configure your MySQL credentials locally, then run:


mvnw.cmd spring-boot:run


Open:

http://localhost:8080

Run tests :

