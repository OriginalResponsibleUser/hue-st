/**
 *  Hue Bulb
 *
 *  Philips Hue Type "Extended Color Light"
 *
 *  Author: SmartThings
 */

// for the UI
metadata {
	// Automatically generated. Make future change here.
	definition (name: "Hue Bulb Jacob", namespace: "smartthings", author: "jacobbraun") {
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
        
        attribute "colorName", "string"
	}

	simulator {
		// TODO: define status and reply messages here
	}

	tiles (scale: 2){
		multiAttributeTile(name:"rich-control", type: "lighting", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "off", label: '${currentValue}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
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
			tileAttribute ("device.level", key: "SLIDER_CONTROL") {
				attributeState "level", action:"switch level.setLevel", range:"(0..100)"
            }
            tileAttribute ("device.level", key: "SECONDARY_CONTROL") {
	            attributeState "level", label: 'Level ${currentValue}%'
			}
			tileAttribute ("device.color", key: "COLOR_CONTROL") {
				attributeState "color", action:"setAdjustedColor"
			}
		}

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
        
        valueTile("colorName", "device.colorName", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
            state "colorName", label: '${currentValue}'
        }

		main(["rich-control"])
		details(["rich-control", "colorTempSliderControl", "colorTemp", "reset", "refresh", "colorName"])
	}
}

// parse events into attributes
def parse(String description) {
 def descMap = parseDescriptionAsMap(description)
	log.debug "parse() - $description"
	def results = []

	def map = description
    def hueValue = Math.round(convertHexToInt(descMap.value) / 255 * 100)
    log.debug "hue value is hueValue"
	if (description instanceof String)  {
		log.debug "Hue Bulb stringToMap - ${map}"
		map = stringToMap(description)
	}

	if (map?.name && map?.value) {
		results << createEvent(name: "${map?.name}", value: "${map?.value}")
	}
	results
}

// handle commands
void on() {
	log.debug "on()"
	log.trace parent.on(this)
    sendEvent(name: "switch", value: "on")
    sendEvent(name: "switchColor", value: ( device.currentValue("colorMode") == "White" ? "White" : device.currentValue("colorName")), displayed: false)
    }

void off() {
	log.trace parent.off(this)
    log.debug "off()"
	sendEvent(name: "switch", value: "off")
        sendEvent(name: "switchColor", value: "off", displayed: false)
}

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

void setLevel(value) {
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

void setHue(percent) {
    log.debug "Executing 'setHue'"
    if (verifyPercent(percent)) {
        parent.setHue(this, percent)
        sendEvent(name: "hue", value: percent, displayed: false)
    }
}

void setColor(value) {
    log.debug "setColor: ${value}, $this"
    def events = []
    def validValues = [:]

    if (value.hex) { sendEvent(name: "color", value: value.hex, displayed:false)}

    def colorName = getColorName(value.hue)
    sendEvent(name: "colorName", value: colorName)
    sendEvent(name: "colorMode", value: "Color")
    sendEvent(name: "switchColor", value: device.currentValue("colorName"), displayed: false)
	
    log.debug "color name is : $colorName"
    
    sendEvent(name: "hue", value: value.hue, displayed:false)
    sendEvent(name: "saturation", value: value.saturation, displayed:false)




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

void setColorTemperature(value) {
    if (value) {
        log.trace "setColorTemperature: ${value}k"
        parent.setColorTemperature(this, value)
        sendEvent(name: "colorTemperature", value: value)
        sendEvent(name: "switch", value: "on")
    } else {
        log.warn "Invalid color temperature"
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


//input Hue Integer values; returns color name for saturation 100%
private getColorName(hueValue){
    if(hueValue>360 || hueValue<0)
        return

    hueValue = Math.round(hueValue / 100 * 360)

    log.debug "hue value is $hueValue"

    def colorName = "Color Mode"
    if(hueValue>=0 && hueValue <= 4){
        colorName = "Red"
    }
    else if (hueValue>=5 && hueValue <=21 ){
        colorName = "Brick Red"
    }
    else if (hueValue>=22 && hueValue <=30 ){
        colorName = "Safety Orange"
    }
    else if (hueValue>=31 && hueValue <=40 ){
        colorName = "Dark Orange"
    }
    else if (hueValue>=41 && hueValue <=49 ){
        colorName = "Amber"
    }
    else if (hueValue>=50 && hueValue <=56 ){
        colorName = "Gold"
    }
    else if (hueValue>=57 && hueValue <=65 ){
        colorName = "Yellow"
    }
    else if (hueValue>=66 && hueValue <=83 ){
        colorName = "Electric Lime"
    }
    else if (hueValue>=84 && hueValue <=93 ){
        colorName = "Lawn Green"
    }
    else if (hueValue>=94 && hueValue <=112 ){
        colorName = "Bright Green"
    }
    else if (hueValue>=113 && hueValue <=135 ){
        colorName = "Lime"
    }
    else if (hueValue>=136 && hueValue <=166 ){
        colorName = "Spring Green"
    }
    else if (hueValue>=167 && hueValue <=171 ){
        colorName = "Turquoise"
    }
    else if (hueValue>=172 && hueValue <=187 ){
        colorName = "Aqua"
    }
    else if (hueValue>=188 && hueValue <=203 ){
        colorName = "Sky Blue"
    }
    else if (hueValue>=204 && hueValue <=217 ){
        colorName = "Dodger Blue"
    }
    else if (hueValue>=218 && hueValue <=223 ){
        colorName = "Navy Blue"
    }
    else if (hueValue>=224 && hueValue <=251 ){
        colorName = "Blue"
    }
    else if (hueValue>=252 && hueValue <=256 ){
        colorName = "Han Purple"
    }
    else if (hueValue>=257 && hueValue <=274 ){
        colorName = "Electric Indigo"
    }
    else if (hueValue>=275 && hueValue <=289 ){
        colorName = "Electric Purple"
    }
    else if (hueValue>=290 && hueValue <=300 ){
        colorName = "Orchid Purple"
    }
    else if (hueValue>=301 && hueValue <=315 ){
        colorName = "Magenta"
    }
    else if (hueValue>=316 && hueValue <=326 ){
        colorName = "Hot Pink"
    }
    else if (hueValue>=327 && hueValue <=335 ){
        colorName = "Deep Pink"
    }
    else if (hueValue>=336 && hueValue <=339 ){
        colorName = "Raspberry"
    }
    else if (hueValue>=340 && hueValue <=352 ){
        colorName = "Crimson"
    }
    else if (hueValue>=353 && hueValue <=360 ){
        colorName = "Red"
    }

    colorName
}