package com.dt.kotlin.aspects

import com.dt.kotlin.annotations.Logging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author shashankmittal
 * @created 18/10/19
 */
@Aspect
@Component
class LoggingAspect {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Pointcut("@annotation(logging)")
    fun funAnnotatedWithLogging(logging: Logging) {
    }

    @Around("funAnnotatedWithLogging(logging)")
    @Throws(Throwable::class)
    fun recordLatencyAdvice(joinPoint: ProceedingJoinPoint, logging: Logging): Any {
        val identifier = "Class : " + joinPoint.signature.declaringType.simpleName + " Method : " + joinPoint.signature.name
        val args = joinPoint.args
        val argsString = Arrays.toString(args)
        try {
            val result = joinPoint.proceed()
            logger.info("IDENTIFIER IS [{}] with ARGUMENTS {} and RESULT [{}]", identifier, argsString, result.toString())
            return result
        } catch (e: Throwable) {
            throw e
        } finally {
        }
    }
}