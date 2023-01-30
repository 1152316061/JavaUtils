package com.datay.secloud.production.bigscreen.utils;
// fix 1
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;

public class DateUtils {

  public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd")
      .withZone(ZoneOffset.ofHours(8));

  /**
   * instant 减操作
   *
   * @param instant
   * @param amount
   * @return
   */
  public static Instant minus(Instant instant, TemporalAmount amount) {
    return LocalDateTime.ofInstant(instant, ZoneOffset.ofHours(8)).minus(amount)
        .toInstant(ZoneOffset.ofHours(8));
  }

  /**
   * instant 提取 日
   *
   * @param instant
   * @return
   */
  public static String getDay(Instant instant) {
    return String.format("%d",LocalDateTime.ofInstant(instant, ZoneOffset.ofHours(8)).getDayOfMonth());
  }

  /**
   * instant 获取同年第一天
   *
   * @param instant
   * @return
   */
  public static Instant getFistDayOfYear(Instant instant) {
    return LocalDateTime.ofInstant(instant, ZoneOffset.ofHours(8))
        .with(TemporalAdjusters.firstDayOfYear()).toInstant(ZoneOffset.ofHours(8));
  }

  public static Instant getLastDayOfMonth(Instant instant) {
    return LocalDateTime.ofInstant(instant, ZoneOffset.ofHours(8))
        .with(TemporalAdjusters.lastDayOfMonth()).toInstant(ZoneOffset.ofHours(8));
  }

  public static Instant getZeroOfDay(Instant instant) {
    return LocalDateTime.ofInstant(instant, ZoneOffset.ofHours(8))
        .withHour(0).withMinute(0).withSecond(0).withNano(0).toInstant(ZoneOffset.ofHours(8));
  }
  public static String formatInstant(Instant instant) {
    return dtf.format(instant);
  }

  public static LocalDateTime convertInstant2LocalDateTime(Instant instant){
    return LocalDateTime.ofInstant(instant, ZoneOffset.ofHours(8));
  }
}
