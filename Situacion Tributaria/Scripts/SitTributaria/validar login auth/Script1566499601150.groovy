import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.logging.KeywordLogger

JsonSlurper slurper = new JsonSlurper()

Map parsedJson = slurper.parseText(t_response.responseBodyContent)

String t_token = parsedJson.get('token')

String t_timestamp = parsedJson.get('timestamp')

if ((t_token == null) || (t_timestamp == null)) {
	KeywordUtil.markFailed('error al recuperar token y/o timestamp')
}

GlobalVariable.g_token = t_token

GlobalVariable.g_timestamp = t_timestamp

KeywordLogger log = new KeywordLogger()
log.logInfo('token global ------------> : ' + GlobalVariable.g_token)
log.logInfo('timestamp global ------------>: ' + GlobalVariable.g_timestamp)
