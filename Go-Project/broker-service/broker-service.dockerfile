# Comment below and use the Makefile from Project folder instead #
# # base go image
# FROM golang:1.22-alpine AS builder

# RUN mkdir /app
# COPY . /app
# WORKDIR /app
# RUN CGO_ENABLED=0 go build -o brokerApp ./cmd/api 
# RUN chmod +x /app/brokerApp 


# #build tiny image
# FROM alpine:latest
# RUN mkdir /app
# COPY --from=builder /app/brokerApp /app
# CMD ["/app/brokerApp"]

#build tiny image
FROM alpine:latest
RUN mkdir /app
COPY brokerApp /app
CMD ["/app/brokerApp"]