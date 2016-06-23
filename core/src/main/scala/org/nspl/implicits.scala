package org.nspl
import org.nspl.data._

trait ImplicitConversions {
  type PlotData = (DataSource, List[DataRenderer], LegendConfig)
  implicit def dsToTuple1[T](ds: T)(implicit f: T => DataSource): PlotData =
    (ds, List(point()), NotInLegend)

  implicit def dsToTuple2a[T](ds: (T, LegendConfig))(
    implicit
    f: T => DataSource
  ): PlotData =
    (ds._1, List(point()), ds._2)

  implicit def dsToTuple2b[T](ds: (T, List[DataRenderer]))(
    implicit
    f: T => DataSource
  ): PlotData =
    (ds._1, ds._2, NotInLegend)

  implicit def dsToTuple3c[T](ds: ((T, DataRenderer), LegendConfig))(
    implicit
    f: T => DataSource
  ): PlotData = (ds._1._1, List(ds._1._2), ds._2)

  implicit def dsToTuple3d[T](ds: ((T, List[DataRenderer]), LegendConfig))(
    implicit
    f: T => DataSource
  ): PlotData = (ds._1._1, ds._1._2, ds._2)

  implicit def dsToTuple2c[T](ds: (T, DataRenderer))(
    implicit
    f: T => DataSource
  ): PlotData = (ds._1, List(ds._2), NotInLegend)

  implicit def dsToTuple3[T](ds: (T, DataRenderer, LegendConfig))(
    implicit
    f: T => DataSource
  ): PlotData = (ds._1, List(ds._2), ds._3)

  implicit def dsToTuple3b[T](ds: (T, List[DataRenderer], LegendConfig))(
    implicit
    f: T => DataSource
  ): PlotData = (ds._1, ds._2, ds._3)

  implicit def listConv1[T](ds: Seq[(T, List[DataRenderer])])(
    implicit
    f: T => DataSource
  ): Seq[PlotData] =
    ds.map(x => (f(x._1), x._2, NotInLegend))

  implicit def listConv2[T](ds: Seq[(T, List[DataRenderer], LegendConfig)])(
    implicit
    f: T => DataSource
  ): Seq[PlotData] =
    ds.map(x => (f(x._1), x._2, x._3))

  implicit def listConv3[T](ds: Seq[(T, DataRenderer, LegendConfig)])(
    implicit
    f: T => DataSource
  ): Seq[PlotData] =
    ds.map(x => (f(x._1), List(x._2), x._3))

  implicit def listConv2b[T](ds: Seq[(T, DataRenderer)])(
    implicit
    f: T => DataSource
  ): Seq[PlotData] =
    ds.map(x => (f(x._1), List(x._2), NotInLegend))
}
