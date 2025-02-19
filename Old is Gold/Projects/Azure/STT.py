import wave
import azure.cognitiveservices.speech as speechsdk
import pyaudio

# Replace with your Azure Speech Service subscription key and service region

service_region = "centralindia"  # e.g., "eastus"service_region
subscription_key = '7635478b91fe482185a9cc18c016b43f'

def recognize_speech_from_microphone():
    speech_config = speechsdk.SpeechConfig(subscription=subscription_key, region=service_region)

    speech_config.speech_recognition_language = "en-IN"
    
    audio_config = speechsdk.AudioConfig(use_default_microphone=True)

    speech_recognizer = speechsdk.SpeechRecognizer(speech_config=speech_config, audio_config=audio_config)

    print("Listening... Press Ctrl+C to stop recording and transcribe.")

    try:
        result = speech_recognizer.recognize_once()
        if result.reason == speechsdk.ResultReason.RecognizedSpeech:
            detected_language = result.properties.get("SpeechServiceResponse_JsonResult")
            # print(f"Detected Language: {detected_language}")
            print("Recognized: {}".format(result.text))
        
        elif result.reason == speechsdk.ResultReason.NoMatch:
            print("No speech could be recognized")
        elif result.reason == speechsdk.ResultReason.Canceled:
            cancellation_details = result.cancellation_details
            print("Speech Recognition canceled: {}".format(cancellation_details.reason))
            if cancellation_details.reason == speechsdk.CancellationReason.Error:
                print("Error details: {}".format(cancellation_details.reason_details))
    except KeyboardInterrupt:
        print("Recording stopped.")

if __name__ == "__main__":
    recognize_speech_from_microphone()



# import azure.cognitiveservices.speech as speechsdk

# # Replace with your Azure Cognitive Services subscription key and service region

# service_region = "centralindia"  # e.g., "eastus"

# def speech_to_text_with_language_detection():
#     speech_config = speechsdk.SpeechConfig(subscription=subscription_key, region=service_region)

#     # Create an audio configuration using the default microphone
#     audio_input = speechsdk.AudioConfig(use_default_microphone=True)

#     speech_recognizer = speechsdk.SpeechRecognizer(speech_config=speech_config, audio_config=audio_input)

#     print("Listening for speech...")

#     result = speech_recognizer.recognize_once()

#     if result.reason == speechsdk.ResultReason.RecognizedSpeech:
#         detected_language = result.properties.get("SpeechServiceResponse_JsonResult")
#         recognized_text = result.text
#         print(f"Detected Language: {detected_language}")
#         print(f"Recognized Text: {recognized_text}")

#     elif result.reason == speechsdk.ResultReason.NoMatch:
#         print("No speech could be recognized")
#     elif result.reason == speechsdk.ResultReason.Canceled:
#         cancellation_details = result.cancellation_details
#         print("Speech Recognition canceled: {}".format(cancellation_details.reason))
#         if cancellation_details.reason == speechsdk.CancellationReason.Error:
#             print("Error details: {}".format(cancellation_details.error_details))  # Corrected attribute name

# if __name__ == "__main__":
#     speech_to_text_with_language_detection()


# KEY = "7635478b91fe482185a9cc18c016b43f"
# REGION = "centralindia"
# import azure.cognitiveservices.speech as speechsdk

# # Replace with your Azure Cognitive Services subscription key and service region

# service_region = "centralindia"  # e.g., "eastus"

# def speech_to_text_with_language_detection():
#     speech_config = speechsdk.SpeechConfig(subscription=subscription_key, region=service_region)

#     # Specify the target language for recognition (e.g., Hindi)
#     speech_config.speech_recognition_language = "hi-IN"

#     # Create an audio configuration using the default microphone
#     audio_input = speechsdk.AudioConfig(use_default_microphone=True)

#     speech_recognizer = speechsdk.SpeechRecognizer(speech_config=speech_config, audio_config=audio_input)

#     print("Listening for speech...")

#     result = speech_recognizer.recognize_once()

#     if result.reason == speechsdk.ResultReason.RecognizedSpeech:
#         detected_language = result.properties.get("SpeechServiceResponse_JsonResult")
#         recognized_text = result.text
#         print(f"Detected Language: {detected_language}")
#         print(f"Recognized Text: {recognized_text}")

#     elif result.reason == speechsdk.ResultReason.NoMatch:
#         print("No speech could be recognized")
#     elif result.reason == speechsdk.ResultReason.Canceled:
#         cancellation_details = result.cancellation_details
#         print("Speech Recognition canceled: {}".format(cancellation_details.reason))
#         if cancellation_details.reason == speechsdk.CancellationReason.Error:
#             print("Error details: {}".format(cancellation_details.error_details))

# if __name__ == "__main__":
#     speech_to_text_with_language_detection()


