import azure.cognitiveservices.speech as speechsdk

# Replace with your Azure Text to Speech subscription key and service region

service_region = "centralindia"
subscription_key = '7635478b91fe482185a9cc18c016b43f'

def text_to_speech_and_speak():
    # Initialize the Azure Speech Config
    speech_config = speechsdk.SpeechConfig(subscription=subscription_key, region=service_region)

    # Create a speech synthesizer
    synthesizer = speechsdk.SpeechSynthesizer(speech_config=speech_config)

    # Ask the user for input
    text_to_convert = input("Enter the text you want to convert to speech: ")

    # Synthesize the input text to speech
    result = synthesizer.speak_text(text_to_convert)

    # Check the result for errors
    if result.reason == speechsdk.ResultReason.SynthesizingAudioCompleted:
        print("Speech synthesis completed.")
    else:
        print("Speech synthesis failed: {}".format(result.reason))

if __name__ == "__main__":
    text_to_speech_and_speak()
