movimento/status
botao/status
sensor/luz
led/potencia

<device>/<attr>

mosquitto_pub -h localhost -t "/ul/group4/<device>/attrs" -m "<attrId>|<value>"

mosquitto_pub -h localhost -t "/ul/group4/movement01/attrs" -m "s|1000"

curl -X GET   'http://localhost:1026/v2/entities'   -H 'fiware-service: openiot'   -H 'fiware-clearservicepath: /' | jq

curl -iX GET   'http://localhost:4041/iot/devices'   -H 'Content-Type: application/json'   -H 'fiware-service: openiot'   -H 'fiware-servicepath: /'