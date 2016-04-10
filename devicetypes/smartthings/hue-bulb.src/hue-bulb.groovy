/**
 *  Hue Bulb
 *
 *  Philips Hue Type "Extended Color Light"
 *
 *  Author: jacobbraun
 
 * Modified from SmartThings/Hue Bulb
 */

// for the UI
metadata {
	// Automatically generated. Make future change here.
	definition (name: "Hue Bulb", namespace: "smartthings", author: "SmartThings") {
		capability "Switch Level"
		capability "Actuator"
		capability "Color Control"
		capability "Color Temperature"
		capability "Switch"
		capability "Refresh"
		capability "Sensor"

		command "setAdjustedColor"
        command "reset"
        command "refresh"
        
        //These taken from Improved Zigbee Hue Bulb MA
        attribute "colorMode", "string"
        attribute "colorName", "string"
        attribute "switchColor", "string"
	}

	simulator {
		// TODO: define status and reply messages here
        // These taken from Improved Zigbee Hue Bulb MA
		status "on": "on/off: 1"
		status "off": "on/off: 0"
	}

	tiles (scale: 2){
		multiAttributeTile(name:"rich-control", type: "lighting", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "off", label:'${name}', action:"switch.on", icon:"st.lights.philips.hue-single", backgroundColor:"#ffffff", nextState:"turningOn"
				attributeState "turningOn", label:'${name}', action:"switch.off", icon:"st.lights.philips.hue-single", backgroundColor:"#79b821", nextState:"turningOff"
				attributeState "turningOff", label:'${name}', action:"switch.on", icon:"st.lights.philips.hue-single", backgroundColor:"#ffffff", nextState:"turningOn"
                attributeState "Red", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff0000"
            	attributeState "Brick Red", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff3700"
    			attributeState "Safety Orange", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff6F00"
    			attributeState "Dark Orange", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff9900"
            	attributeState "Amber", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ffbf00"
            	attributeState "Gold", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ffe1000"
            	attributeState "Yellow", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ffff00"
    			attributeState "Electric Lime", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#bfff00"
            	attributeState "Lawn Green", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#88ff00"
            	attributeState "Bright Green", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#48ff00"
            	attributeState "Lime", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00ff11"
            	attributeState "Spring Green", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00ff6a"
            	attributeState "Turquoise", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00ffd0"
            	attributeState "Aqua", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00ffff"
            	attributeState "Sky Blue", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00bfff"
            	attributeState "Dodger Blue", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#007bff"
            	attributeState "Navy Blue", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#0050ff"
            	attributeState "Blue", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#0000ff"
            	attributeState "Han Purple", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#3b00ff"
            	attributeState "Electric Indigo", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#6600ff"
            	attributeState "Electric Purple", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#b200ff"
            	attributeState "Orchid Purple", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#e900ff"
            	attributeState "Magenta", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff00dc"
            	attributeState "Hot Pink", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff00aa"
            	attributeState "Deep Pink", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff007b"
            	attributeState "Raspberry", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff0061"
            	attributeState "Crimson", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff003b"
            	attributeState "White", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
			}
            //from zigbee hue improved ma
           
           tileAttribute ("device.color", key: "COLOR_CONTROL") {
            	attributeState "color", action: "setAdjustedColor"
           }
           
           tileAttribute ("device.level", key: "SECONDARY_CONTROL") {
            	attributeState "level", label: 'Level is ${currentValue}%'
            }
        }
                
			/* Old Hue Functions
            tileAttribute ("device.level", key: "SLIDER_CONTROL") {
				attributeState "level", action:"switch level.setLevel", range:"(0..100)"
            
            }
            tileAttribute ("device.level", key: "SECONDARY_CONTROL") {
	            attributeState "level", label: 'Level ${currentValue}%'
			}
			tileAttribute ("device.color", key: "COLOR_CONTROL") {
				attributeState "color", action:"setAdjustedColor"
			}
            */


		/*
        controlTile("colorTempSliderControl", "device.colorTemperature", "slider", width: 4, height: 2, inactiveLabel: false, range:"(2000..6500)") {
            state "colorTemperature", action:"color temperature.setColorTemperature"
        }

        valueTile("colorTemp", "device.colorTemperature", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
            state "colorTemperature", label: '${currentValue} K'
        }

		standardTile("reset", "device.reset", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
			state "default", label:"Reset Color", action:"reset", icon:"st.lights.philips.hue-single"
		}

		standardTile("refresh", "device.refresh", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
		}

		main(["rich-control"])
		details(["rich-control", "colorTempSliderControl", "colorTemp", "reset", "refresh"])
        
        
	}
    */
    
    standardTile("refresh", "device.switch", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
		}
		controlTile("levelSliderControl", "device.level", "slider", height: 1, width: 4, inactiveLabel: false) {
			state "level", action:"switch level.setLevel"
		}
        controlTile("colorTempSliderControl", "device.colorTemperature", "slider", height: 1, width: 4, inactiveLabel: false, range:"(2000..6500)") {
            state "colorTemperature", action:"color temperature.setColorTemperature"
        }
        valueTile("colorTemp", "device.colorTemperature", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
            state "colorTemperature", label: '${currentValue} K'
        }
        valueTile("colorName", "device.colorName", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
            state "colorName", label: '${currentValue}'
        }
        valueTile("colorMode", "device.colorMode", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
            state "colorMode", label: '${currentValue}'
        }
        
        
		main(["switch"])
		details(["switch", "levelSliderControl", "colorName", "colorTempSliderControl", "colorTemp", "colorMode", "refresh"])
	
}
}

// parse events into attributes
/*
def parse(description) {
	log.debug "parse() - $description"
    
    sendEvent(name: "unreachable", value: 0, displayed: false)
	def results = []

	def map = description
	if (description instanceof String)  {
		log.debug "Hue Bulb stringToMap - ${map}"
		map = stringToMap(description)
	}

	if (map?.name && map?.value) {
		results << createEvent(name: "${map?.name}", value: "${map?.value}")
	}
	results
}
*/

def parse(String description) {
   log.info "description is $description"
    
    sendEvent(name: "unreachable", value: 0, displayed: false)
    
    if (description?.startsWith("catchall:")) {
        if(description?.endsWith("0100") ||description?.endsWith("1001") || description?.matches("on/off\\s*:\\s*1"))
        {
            def result = createEvent(name: "switch", value: "on")
            sendEvent(name: "switchColor", value: ( device.currentValue("colorMode") == "White" ? "White" : device.currentValue("colorName")), displayed: false)
            log.debug "Parse returned ${result?.descriptionText}"
            return result
        }
        else if(description?.endsWith("0000") || description?.endsWith("1000") || description?.matches("on/off\\s*:\\s*0"))
        {
            if(!(description?.startsWith("catchall: 0104 0300") || description?.startsWith("catchall: 0104 0008"))){
                def result = createEvent(name: "switch", value: "off")
                sendEvent(name: "switchColor", value: "off", displayed: false)
                log.debug "Parse returned ${result?.descriptionText}"
                return result
            }
        }
    }
    else if (description?.startsWith("read attr -")) {
        def descMap = parseDescriptionAsMap(description)
       // log.trace "descMap : $descMap"

        if (descMap.cluster == "0300") {
            if(descMap.attrId == "0000"){  //Hue Attribute
                def hueValue = Math.round(convertHexToInt(descMap.value) / 255 * 100)
                log.debug "Hue value returned is $hueValue"
                def colorName = getColorName(hueValue)
    			sendEvent(name: "colorName", value: colorName)
                if (device.currentValue("switch") == "on") { sendEvent(name: "switchColor", value: ( device.currentValue("colorMode") == "White" ? "White" : device.currentValue("colorName")), displayed: false) }
                sendEvent(name: "hue", value: hueValue, displayed:false)
            }
            else if(descMap.attrId == "0001"){ //Saturation Attribute
                def saturationValue = Math.round(convertHexToInt(descMap.value) / 255 * 100)
                log.debug "Saturation from refresh is $saturationValue"
                sendEvent(name: "saturation", value: saturationValue, displayed:false)
            }
            else if( descMap.attrId == "0007") {
                def tempInMired = convertHexToInt(descMap.value)
            	def tempInKelvin = Math.round(1000000/tempInMired)
                log.debug "Color temperature returned is $tempInKelvin"
            	sendEvent(name: "colorTemperature", value: tempInKelvin)
            }
            else if( descMap.attrId == "0008") {
            	def colorModeValue = (descMap.value == "02" ? "White" : "Color")
                log.debug "Color mode returned $colorModeValue"
                sendEvent(name: "colorMode", value: colorModeValue)
                if (device.currentValue("switch") == "on") {
                	sendEvent(name: "switchColor", value: (descMap.value == "02" ? "White" : device.currentValue("colorName")), displayed: false)
                }
            }
        }
        else if(descMap.cluster == "0008"){
            def dimmerValue = Math.round(convertHexToInt(descMap.value) * 100 / 255)
            log.debug "dimmer value is $dimmerValue"
            sendEvent(name: "level", value: dimmerValue)
        }
    }
    else {
        def name = description?.startsWith("on/off: ") ? "switch" : null
        if (name == "switch") {
            def value = (description?.endsWith(" 1") ? "on" : "off")
        	log.debug value
            sendEvent(name: "switchColor", value: (value == "off" ? "off" : device.currentValue("colorName")), displayed: false)
        }
        else { def value = null }
        def result = createEvent(name: name, value: value)
        log.debug "Parse returned ${result?.descriptionText}"
        return result
    }

}
def parseDescriptionAsMap(description) {
    (description - "read attr - ").split(",").inject([:]) { map, param ->
        def nameAndValue = param.split(":")
        map += [(nameAndValue[0].trim()):nameAndValue[1].trim()]
    }
}

// handle commands
def on() {
	log.trace parent.on(this)
	sendEvent(name: "switch", value: "on")
    	sendEvent(name: "switchColor", value: ( device.currentValue("colorMode") == "White" ? "White" : device.currentValue("colorName")), displayed: false)
}

def off() {
	log.trace parent.off(this)
	sendEvent(name: "switch", value: "off")
    	sendEvent(name: "switchColor", value: "off", displayed: false)
}

def setColorTemperature(value) {
    if(value<101){
        value = (value*38) + 2700		//Calculation of mapping 0-100 to 2700-6500
    }

    def tempInMired = Math.round(1000000/value)
    def finalHex = swapEndianHex(hexF(tempInMired, 4))
   // def genericName = getGenericName(value)
   // log.debug "generic name is : $genericName"

    def cmds = []
    
    if (device.latestValue("switch") == "off") {
        log.debug value
    }
    sendEvent(name: "colorTemperature", value: value, displayed:false)
    sendEvent(name: "colorMode", value: "White")
    sendEvent(name: "switchColor", value: "White", displayed: false)
   // sendEvent(name: "colorName", value: genericName)
}


void setHue(percent) {
    log.debug "Executing 'setHue'"
    if (verifyPercent(percent)) {
        parent.setHue(this, percent)
        sendEvent(name: "hue", value: percent, displayed: false)
    }
}



/*
def setColorTemperature(value) {
    if (value) {
        log.trace "setColorTemperature: ${value}k"
        if(value<101){
        value = (value*38) + 2700		//Calculation of mapping 0-100 to 2700-6500
    }
    
     def tempInMired = Math.round(1000000/value)
    def finalHex = swapEndianHex(hexF(tempInMired, 4))
    
//        parent.setColorTemperature(this, value)
        sendEvent(name: "colorTemperature", value: value)
        sendEvent(name: "switch", value: "on")
    } else {
        log.warn "Invalid color temperature"
    }
}
*/

void nextLevel() {
	def level = device.latestValue("level") as Integer ?: 0
	if (level <= 100) {
		level = Math.min(25 * (Math.round(level / 25) + 1), 100) as Integer
	}
	else {
		level = 25
	}
	setLevel(level)
}

void setLevel(percent) {
    log.debug "Executing 'setLevel'"
    if (verifyPercent(percent)) {
        parent.setLevel(this, percent)
        sendEvent(name: "level", value: percent, descriptionText: "Level has changed to ${percent}%")
        sendEvent(name: "switch", value: "on")
    }
}

void setSaturation(percent) {
    log.debug "Executing 'setSaturation'"
    if (verifyPercent(percent)) {
        parent.setSaturation(this, percent)
        sendEvent(name: "saturation", value: percent, displayed: false)
    }
}

void setColor(value) {
    log.debug "setColor: ${value}, $this"
    def events = []
    def validValues = [:]

    if (verifyPercent(value.hue)) {
        events << createEvent(name: "hue", value: value.hue, displayed: false)
        validValues.hue = value.hue
    }
    if (verifyPercent(value.saturation)) {
        events << createEvent(name: "saturation", value: value.saturation, displayed: false)
        validValues.saturation = value.saturation
    }
    if (value.hex != null) {
        if (value.hex ==~ /^\#([A-Fa-f0-9]){6}$/) {
            events << createEvent(name: "color", value: value.hex)
            validValues.hex = value.hex
        } else {
            log.warn "$value.hex is not a valid color"
        }
    }
    if (verifyPercent(value.level)) {
        events << createEvent(name: "level", value: value.level, descriptionText: "Level has changed to ${value.level}%")
        validValues.level = value.level
    }
    if (value.switch == "off" || (value.level != null && value.level <= 0)) {
        events << createEvent(name: "switch", value: "off")
        validValues.switch = "off"
    } else {
        events << createEvent(name: "switch", value: "on")
        validValues.switch = "on"
    }
    if (!events.isEmpty()) {
        parent.setColor(this, validValues)
    }
    events.each {
        sendEvent(it)
    }
}

void reset() {
    log.debug "Executing 'reset'"
    def value = [level:100, saturation:56, hue:23]
    setAdjustedColor(value)
    parent.poll()
}

void setAdjustedColor(value) {
    if (value) {
        log.trace "setAdjustedColor: ${value}"
        def adjusted = value + [:]
        adjusted.hue = adjustOutgoingHue(value.hue)
        // Needed because color picker always sends 100
        adjusted.level = null
        setColor(adjusted)
    } else {
        log.warn "Invalid color input"
    }
}

void refresh() {
    log.debug "Executing 'refresh'"
    parent.manualRefresh()
}

def adjustOutgoingHue(percent) {
	def adjusted = percent
	if (percent > 31) {
		if (percent < 63.0) {
			adjusted = percent + (7 * (percent -30 ) / 32)
		}
		else if (percent < 73.0) {
			adjusted = 69 + (5 * (percent - 62) / 10)
		}
		else {
			adjusted = percent + (2 * (100 - percent) / 28)
		}
	}
	log.info "percent: $percent, adjusted: $adjusted"
	adjusted
}

def verifyPercent(percent) {
    if (percent == null)
        return false
    else if (percent >= 0 && percent <= 100) {
        return true
    } else {
        log.warn "$percent is not 0-100"
        return false
    }
}