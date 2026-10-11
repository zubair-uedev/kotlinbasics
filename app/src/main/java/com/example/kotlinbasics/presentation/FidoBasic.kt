package com.example.kotlinbasics.presentation

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// 👉 GUIDE: API 1 ka jawab. PaySubmitFeido() isay return karta hai.
data class PaySubmitFidoResponse(
    val isSuccess: Boolean,
    val otpValue: Int,
    val fidoAttestation: String,
    val challengeID: String
)

//Api 2 ka jawab
data class FidoVerifyResponse(
    val isSuccess: Boolean,
    val message: String
)

data class PayConfirmResponse(
    val isSuccess: Boolean,
    val transactionId: String,
    val message: String
)

class PaymentService {
    suspend fun PaySubmitFido(amount: Double): PaySubmitFidoResponse {
        println("📡 [API 1] Sending Initial Payment Request for Rs. $amount...")
        return PaySubmitFidoResponse(
            isSuccess = true,
            otpValue = 100,
            fidoAttestation = "{\"challenge\": \"RAW_CHALLENGE_FROM_SERVER_123\"}",
            challengeID = "RAW_CHALLENGE_FROM_SERVER_1122"
        )
    }

    suspend fun ScenFingerPrintAndSignChallenge(ChallengePayLoad: String): String {
        println("👆 [HARDWARE] Opening Fingerprint Scanner...")
        println("👤 [USER] User scanned Fingerprint successfully!")
        delay(1000)
        println("🔐 [KEYSTORE] Mobile Hardware KeyStore signed the challenge with Private Key.")
        return "{\"Signature\" :\"Signed_By_Device_Private_Key_786_MZubair\""
    }

    suspend fun FidoVerifyChallenge(SignedResponseJson: String): FidoVerifyResponse {
        println("[Api 2] Sending Signed Response to Server for FIDO Verification...")
        delay(1300)
        println("[Api 2]  Server verify Signature using register public key and challengeId")
        return FidoVerifyResponse(
            isSuccess = true,
            message = "Fide Challenge Verify Successfully"
        )
    }

    // 👉 GUIDE: [API 3]
    suspend fun PayConfirmSubmitFido(challengeID: String, amount: Double): PayConfirmResponse {
        println("📡 [API 3] Sending Final Payment Confirm Request with ChallengeId: $challengeID...")
        delay(1300)
        return PayConfirmResponse(
            isSuccess = true,
            transactionId = "TXN_UBL_785_1122",
            message = "Payment Transfer Successfuly"
        )
    }
}

// 👉 GUIDE: PaymentJourneyController = MANAGER. Decide karta hai ke ab
// 👉 GUIDE: kaunsa function chalega. Service ke functions yahi bulata hai.
class PaymentJourneyController(private val service: PaymentService) {
    // Slide Complete hone par ye function call hota hai
    suspend fun onSlideToPayComplete(amount: Double) {
        println("\n==========================================")
        println("🟢 STEP 1: User Completed Slide to Pay Gesture start hear")
        println("==========================================")
        // 👉 GUIDE: API 1 call hui (Service ka function)
        val submitResponse = service.PaySubmitFido(amount = amount)
        if (submitResponse.isSuccess) {
            println("\n🟢 STEP 2: Initial API Success (otpValue = ${submitResponse.otpValue})")
            // FIDO Process Start Point!
            checkPassKeyAndStartFido(submitResponse, amount)

        } else {
            // 👉 GUIDE: API 1 fail hui to yahin khatam, baaqi koi function nahi chalta
            println("Initail API Failed!")
        }
    }

    private suspend fun checkPassKeyAndStartFido(
        response: PaySubmitFidoResponse,
        amount: Double
    ) {
        println("\n Step 3: Checking Fide/passkey Fideo Status...")
        if (response.otpValue == 100) {
            println("✅ User is registered for FIDO. Triggering Biometric Prompt...")
            // 👉 GUIDE: Service ka function: fingerprint scan + challenge sign
            val signChallenge = service.ScenFingerPrintAndSignChallenge(response.fidoAttestation)
            // 👉 GUIDE: Service ka function: API 2, server signature verify karega
            val verifyResponse = service.FidoVerifyChallenge(SignedResponseJson = signChallenge)
            if (verifyResponse.isSuccess) {
                println("\n🟢 STEP 4: FIDO Verification Passed! Executing Final Payment...")
                // C. Final Payment Confirm API Call
                // 👉 GUIDE: verification pass, ab final payment wala function
                excuteFinalPayment(response.challengeID, amount)
            } else {
                // 👉 GUIDE: server ne reject kiya to yahin khatam, payment nahi hoti
                println("❌ FIDO Verification Failed on Server!")
            }
        } else if (response.otpValue == 1) {
            // 👉 GUIDE: fingerprint, verify, payment: koi function nahi chalta
            println("📩 Manual OTP Required (Fallback Flow)")
            // 👉 GUIDE: ---------- RAASTA 3: DIRECT ----------
        } else {
            // Direct Payment
            // 👉 GUIDE: fingerprint aur verify skip, seedha payment
            excuteFinalPayment(response.challengeID, amount)
        }
    }

    private suspend fun excuteFinalPayment(challengeId: String, amount: Double) {
        // 👉 GUIDE: API 3 call hui (Service ka function)
        val payConfirmResponse =
            service.PayConfirmSubmitFido(challengeID = challengeId, amount = amount)
        if (payConfirmResponse.isSuccess) {
            println("\n🏆==========================================")
            println("🎉 PAYMENT COMPLETED SUCCESSFULLY!")
            println("Transaction ID: ${payConfirmResponse.transactionId}")
            println("Status: ${payConfirmResponse.message}")
            println("Slider UI: Transitions to GREEN CHECKMARK ✅")
            println("==========================================\n")
        } else {
            println("❌ Final Payment Confirmation Failed!")
        }
    }
}

fun main() = runBlocking {
    val paymentService = PaymentService()
    val controller = PaymentJourneyController(paymentService)
    controller.onSlideToPayComplete(5000.9)
}
