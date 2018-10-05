package com.smassive.fullbodybuilder.data.datasource.local

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.smassive.fullbodybuilder.R
import com.smassive.fullbodybuilder.core.util.onErrorStub
import com.smassive.fullbodybuilder.workout.data.datasource.local.model.WorkoutEntity
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import org.koin.standalone.KoinComponent

class DbPrepopulator(
    context: Context,
    private val lazyDatabase: Lazy<FullbodyBuilderLocalSource>
) : RoomDatabase.Callback(), KoinComponent {

  private val database: FullbodyBuilderLocalSource by lazy { lazyDatabase.value }

  private val weekWorkouts = listOf(
      WorkoutEntity(1, context.getString(R.string.workout_title_week_1)),
      WorkoutEntity(2, context.getString(R.string.workout_title_week_2)),
      WorkoutEntity(3, context.getString(R.string.workout_title_week_3)),
      WorkoutEntity(4, context.getString(R.string.workout_title_week_4)),
      WorkoutEntity(5, context.getString(R.string.workout_title_week_5)),
      WorkoutEntity(6, context.getString(R.string.workout_title_week_6)),
      WorkoutEntity(7, context.getString(R.string.workout_title_week_7)),
      WorkoutEntity(8, context.getString(R.string.workout_title_week_8)),
      WorkoutEntity(9, context.getString(R.string.workout_title_week_9)),
      WorkoutEntity(10, context.getString(R.string.workout_title_week_10)),
      WorkoutEntity(11, context.getString(R.string.workout_title_week_11)),
      WorkoutEntity(12, context.getString(R.string.workout_title_week_12)),
      WorkoutEntity(13, context.getString(R.string.workout_title_week_13)),
      WorkoutEntity(14, context.getString(R.string.workout_title_week_14)),
      WorkoutEntity(15, context.getString(R.string.workout_title_week_15)),
      WorkoutEntity(16, context.getString(R.string.workout_title_week_16)),
      WorkoutEntity(17, context.getString(R.string.workout_title_week_17)),
      WorkoutEntity(18, context.getString(R.string.workout_title_week_18)),
      WorkoutEntity(19, context.getString(R.string.workout_title_week_19)),
      WorkoutEntity(20, context.getString(R.string.workout_title_week_20)),
      WorkoutEntity(21, context.getString(R.string.workout_title_week_21)),
      WorkoutEntity(22, context.getString(R.string.workout_title_week_22)),
      WorkoutEntity(23, context.getString(R.string.workout_title_week_23)),
      WorkoutEntity(24, context.getString(R.string.workout_title_week_24)),
      WorkoutEntity(25, context.getString(R.string.workout_title_week_25)),
      WorkoutEntity(26, context.getString(R.string.workout_title_week_26)),
      WorkoutEntity(27, context.getString(R.string.workout_title_week_27)),
      WorkoutEntity(28, context.getString(R.string.workout_title_week_28)),
      WorkoutEntity(29, context.getString(R.string.workout_title_week_29)),
      WorkoutEntity(30, context.getString(R.string.workout_title_week_30)),
      WorkoutEntity(31, context.getString(R.string.workout_title_week_31)),
      WorkoutEntity(32, context.getString(R.string.workout_title_week_32)),
      WorkoutEntity(33, context.getString(R.string.workout_title_week_33)),
      WorkoutEntity(34, context.getString(R.string.workout_title_week_34)),
      WorkoutEntity(35, context.getString(R.string.workout_title_week_35)),
      WorkoutEntity(36, context.getString(R.string.workout_title_week_36)),
      WorkoutEntity(37, context.getString(R.string.workout_title_week_37)),
      WorkoutEntity(38, context.getString(R.string.workout_title_week_38)),
      WorkoutEntity(39, context.getString(R.string.workout_title_week_39)),
      WorkoutEntity(40, context.getString(R.string.workout_title_week_40)),
      WorkoutEntity(41, context.getString(R.string.workout_title_week_41)),
      WorkoutEntity(42, context.getString(R.string.workout_title_week_42)),
      WorkoutEntity(43, context.getString(R.string.workout_title_week_43)),
      WorkoutEntity(44, context.getString(R.string.workout_title_week_44)),
      WorkoutEntity(45, context.getString(R.string.workout_title_week_45)),
      WorkoutEntity(46, context.getString(R.string.workout_title_week_46)),
      WorkoutEntity(47, context.getString(R.string.workout_title_week_47)),
      WorkoutEntity(48, context.getString(R.string.workout_title_week_48)),
      WorkoutEntity(49, context.getString(R.string.workout_title_week_49)),
      WorkoutEntity(50, context.getString(R.string.workout_title_week_50)),
      WorkoutEntity(51, context.getString(R.string.workout_title_week_51)),
      WorkoutEntity(52, context.getString(R.string.workout_title_week_52))
  )

  @SuppressLint("CheckResult")
  override fun onCreate(db: SupportSQLiteDatabase) {
    super.onCreate(db)
    Completable.fromCallable {
      database.workoutDao().insertAll(weekWorkouts)
    }.subscribeOn(Schedulers.io()).subscribe({}, onErrorStub)
  }
}